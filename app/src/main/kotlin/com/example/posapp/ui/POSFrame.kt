package com.example.posapp.ui

import javax.swing.*
import java.awt.*

class POSFrame : JFrame() {
    init {
        title = "POS System"
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(1024, 768)
        layout = BorderLayout()
        
        setupUI()
        setLocationRelativeTo(null)
    }
    
    private fun setupUI() {
        add(createToolbar(), BorderLayout.NORTH)
        add(createMainPanel(), BorderLayout.CENTER)
        add(createStatusBar(), BorderLayout.SOUTH)
    }
    
    private fun createToolbar(): JToolBar {
        return JToolBar().apply {
            isFloatable = false
            add(JButton("New Sale"))
            add(JButton("Products"))
            add(JButton("Reports"))
        }
    }
    
    private fun createMainPanel(): JPanel {
        return JPanel(BorderLayout()).apply {
            add(JLabel("Welcome to POS System", SwingConstants.CENTER))
        }
    }
    
    private fun createStatusBar(): JPanel {
        return JPanel(FlowLayout(FlowLayout.LEFT)).apply {
            add(JLabel("Ready"))
        }
    }
}