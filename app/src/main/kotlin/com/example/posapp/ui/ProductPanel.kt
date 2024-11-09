package com.example.posapp.ui

import javax.swing.*
import java.awt.*
import javax.swing.table.DefaultTableModel
import com.example.posapp.model.Product
import com.example.posapp.db.Database

class ProductPanel : JPanel() {
    private val tableModel = DefaultTableModel(
        arrayOf("ID", "Name", "Price", "Stock"),
        0
    )
    private val table = JTable(tableModel)
    
    init {
        layout = BorderLayout()
        setupUI()
        loadProducts()
    }
    
    private fun setupUI() {
        // Product management buttons
        val topPanel = JPanel(FlowLayout(FlowLayout.LEFT)).apply {
            add(JButton("Add Product").apply {
                addActionListener {
                    showAddProductDialog()
                }
            })
            add(JButton("Edit Product").apply {
                addActionListener {
                    editSelectedProduct()
                }
            })
            add(JButton("Delete Product").apply {
                addActionListener {
                    deleteSelectedProduct()
                }
            })
        }
        
        // Products table
        val centerPanel = JScrollPane(table)
        
        add(topPanel, BorderLayout.NORTH)
        add(centerPanel, BorderLayout.CENTER)
    }
    
    private fun showAddProductDialog() {
        val dialog = JDialog(SwingUtilities.getWindowAncestor(this) as JFrame, "Add Product", true)
        dialog.layout = BorderLayout()
        
        val form = JPanel(GridLayout(4, 2, 5, 5)).apply {
            add(JLabel("Name:"))
            val nameField = JTextField()
            add(nameField)
            
            add(JLabel("Price:"))
            val priceField = JTextField()
            add(priceField)
            
            add(JLabel("Stock:"))
            val stockField = JTextField()
            add(stockField)
            
            add(JButton("Save").apply {
                addActionListener {
                    // TODO: Save product to database
                    dialog.dispose()
                    loadProducts()
                }
            })
            add(JButton("Cancel").apply {
                addActionListener {
                    dialog.dispose()
                }
            })
        }
        
        dialog.add(form)
        dialog.pack()
        dialog.setLocationRelativeTo(this)
        dialog.isVisible = true
    }
    
    private fun editSelectedProduct() {
        val row = table.selectedRow
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product to edit")
            return
        }
        // TODO: Implement edit functionality
    }
    
    private fun deleteSelectedProduct() {
        val row = table.selectedRow
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product to delete")
            return
        }
        // TODO: Implement delete functionality
    }
    
    private fun loadProducts() {
        // TODO: Load products from database
        tableModel.rowCount = 0
        // Sample data
        tableModel.addRow(arrayOf(1, "Sample Product", 9.99, 100))
    }
}