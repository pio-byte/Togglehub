package com.example.toggleapp;

import android.content.Intent;
import android.provider.Settings;
import android.service.quicksettings.TileService;
import android.widget.Toast;

public class LockScreenTileService extends TileService {

    @Override
    public void onClick() {
        super.onClick();
        
        boolean success = ScreenLockAccessibilityService.lock();
        
        if (!success) {
            Toast.makeText(this, "Attiva prima il servizio di Accessibilità", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
