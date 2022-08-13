class Order(var osn: Int, private val customer: Customer) {

    var status = OrderStatus.PENDING
    var toteIDs = arrayListOf<Int>()

    override fun toString(): String {
        return  """
        OSN: $osn
        Status: $status
        Customer: $customer
        Tote IDs: ${toteIDs.joinToString()}
                """
    }

}

enum class OrderStatus {
    PENDING, READY, DISPENSED, CANCELLED
}