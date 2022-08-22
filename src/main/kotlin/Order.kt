class Order(private val store: Store, val customer: Customer) {

    val osn = store.assignOSN()
    var status = OrderStatus.PENDING
    var totes = ArrayList<Tote>()

    enum class OrderStatus(val active: Boolean) {
        PENDING(true),
        READY(true),
        DISPENSED(false),
        CANCELLED(false)
    }

    fun changeOrderStatus(newStatus: OrderStatus) {
        status = newStatus
    }

    fun addNewTote() {
        totes.add(Tote(store.assignToteID()))
    }

    override fun toString(): String {
        return  """
        OSN: $osn
        Status: $status
        Customer: $customer
        Totes: ${totes.joinToString("\n")}
                """.trimIndent()
    }
}