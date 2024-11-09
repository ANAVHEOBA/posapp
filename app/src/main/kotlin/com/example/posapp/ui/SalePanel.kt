package com.example.posapp.ui

import javax.swing.*
import java.awt.*
import javax.swing.table.DefaultTableModel
import com.example.posapp.model.Product
import com.example.posapp.model.Sale
import com.example.posapp.db.Database

class SalePanel : JPanel() {
    private val tableModel = DefaultTableModel(
        arrayOf("Product", "Price", "Quantity", "Total"),
        0
    )
    private val table = JTable(tableModel)
    private val totalLabel = JLabel("Total: $0.00")
    
    init {
        layout = BorderLayout()
        setupUI()
    }
    
    private fun setupUI() {
        // Product entry panel
        val topPanel = JPanel(FlowLayout(FlowLayout.LEFT)).apply {
            add(JLabel("Product Code:"))
            add(JTextField(15).apply {
                addActionListener {
                    // TODO: Handle product lookup and add to sale
                }
            })
            add(JButton("Add").apply {
                addActionListener {
                    // TODO: Add product to sale
                }
            })
        }
        
        // Sale items table
        val centerPanel = JScrollPane(table)
        
        // Totals and payment panel
        val bottomPanel = JPanel(BorderLayout()).apply {
            add(totalLabel, BorderLayout.WEST)
            add(JPanel().apply {
                add(JButton("Complete Sale").apply {
                    addActionListener {
                        completeSale()
                    }
                })
                add(JButton("Cancel Sale").apply {
                    addActionListener {
                        cancelSale()
                    }
                })
            }, BorderLayout.EAST)
        }
        
        add(topPanel, BorderLayout.NORTH)
        add(centerPanel, BorderLayout.CENTER)
        add(bottomPanel, BorderLayout.SOUTH)
    }
    
    private fun completeSale() {
        // TODO: Implement sale completion
        JOptionPane.showMessageDialog(this, "Sale completed!")
        clearSale()
    }
    
    private fun cancelSale() {
        clearSale()
    }
    
    private fun clearSale() {
        tableModel.rowCount = 0
        totalLabel.text = "Total: $0.00"
    }
}