class Tote(val toteID: Int) {

    private var items = ArrayList<String>()
    private var status = ToteStatus.PENDING
    private var location = ""

    fun getToteStatus(): ToteStatus {
        return this.status
    }

    fun setToteStatus(status: ToteStatus) {
        this.status = status
    }

    fun stageTote(location: String) {
        this.location = location
    }

    enum class ToteStatus(val status: String) {
        PENDING("Pending"),
        STAGED("Staged"),
        REMOVED("No longer ")
    }

    private fun getToteItems(): String {
        if(this.items.isNotEmpty()) {
            return """
                  ${this.items.joinToString()}
            """
        }
        return """
              No items in tote
        """
    }

    override fun toString(): String {
        return """
          Tote ID: ${this.toteID}
          Tote Status: ${this.status.status}
          Items:
            ${getToteItems()}
        """
    }
}