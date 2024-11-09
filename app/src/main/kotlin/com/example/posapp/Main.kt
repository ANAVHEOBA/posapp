package com.example.posapp

import com.example.posapp.ui.POSFrame
import com.formdev.flatlaf.FlatLightLaf
import javax.swing.SwingUtilities

fun main() {
    // Set the look and feel
    FlatLightLaf.setup()

    // Launch the application
    SwingUtilities.invokeLater {
        POSFrame().apply {
            isVisible = true
        }
    }
}