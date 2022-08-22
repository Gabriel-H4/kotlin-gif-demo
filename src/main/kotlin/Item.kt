class Item(private val name: String, private val upc: Int) {

    private var status = ItemStatus.PENDING

    fun getItemStatus(): ItemStatus {
        return status
    }

    fun setItemStatus(newStatus: ItemStatus) {
        status = newStatus
    }

    enum class ItemStatus(val status: String) {
        PENDING("Pending"),
        PICKED("Picked"),
        NILPICKED("Nilpicked")
    }

    override fun toString(): String {
        return """
            Name: $name
            UPC: $upc
            Status: ${status.status}
        """.trimIndent()
    }
}