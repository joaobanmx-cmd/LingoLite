package com.lingolite.app

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.util.Log

class ScreenTranslatorService : AccessibilityService() {

    companion object {
        private const val TAG = "ScreenTranslatorService"
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // Aqui ficará a lógica de captura e tradução do ecrã
        if (event?.eventType == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED) {
            val packageName = event.packageName?.toString() ?: ""
            Log.d(TAG, "Conteúdo alterado na app: $packageName")
        }
    }

    override fun onInterrupt() {
        Log.d(TAG, "Serviço interrompido")
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        Log.d(TAG, "LingoLite Accessibility Service conectado com sucesso!")
    }
}
