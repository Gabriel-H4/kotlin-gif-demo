class Order2(val store: Store2, val customer: Customer2) {

    val osn = store.assignOSN()
    var status = OrderStatus2.PENDING
    var toteIDs = ArrayList<Int>()

    enum class OrderStatus2(val active: Boolean) {
        PENDING(true),
        READY(true),
        DISPENSED(false),
        CANCELLED(false)
    }

    fun changeOrderStatus(newStatus: OrderStatus2) {
        status = newStatus
    }

    fun addNewTote() {
        toteIDs.add(store.assignToteID())
    }

    override fun toString(): String {
        return  """
        OSN: $osn
        Status: $status
        Customer: $customer
        Tote IDs: ${toteIDs.joinToString()}
                """.trimIndent()
    }
}