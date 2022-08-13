class InputHandler(private val store: Store2) {

    private enum class ParseSystem {
        NUMERICAL, ALPHANUMERICAL, BOOLEAN
    }

    private fun requestHandler(input: String, context: ParseSystem) {
        if(context == ParseSystem.NUMERICAL) {
            val userInputConverted = input.toIntOrNull()?.also { selection ->
                when(selection) {
                    0 -> println(store.allToteIDs.joinToString())
                    1 -> TODO("Order Numbers not yet implemented")
                    2 -> TODO("Order Numbers not yet implemented")
                    3 -> TODO("Customer Array not yet implemented")
                    4 -> println(store.assignToteID())
                    5 -> TODO("Remove deprecated option")
                    8 -> greet()
                    9 -> leave()
                    100 -> genDebugInfo()
                    else -> {
                        println("Invalid number specified")
                    }
                }
            } ?: run {
                println("Invalid input: Only choose a number")
            }
        }
        else if(context == ParseSystem.ALPHANUMERICAL) {
            println("You input a String reply: $input")
        }
        else {
            println("You input a Boolean reply: $input")
        }
    }

    fun greet() {
        println("--------------------------")
        println("--- Welcome to GIF 9.0 ---")
        println("-- Developed by Gabriel --")
        println("--------------------------")
    }

    fun mainMenu() {
        println("\nSelect an option: ")
        println("0. View all Tote IDs")
        println("1. View all Active Order Numbers")
        println("2. View all Past Order Numbers")
        println("3. Get customer info")
        println("4. Generate Tote ID")
        println("5. Migrate past orders")
        println("8. Greet")
        println("9. Exit")
        println("100. genDebugInfo")
        requestHandler(readln(), ParseSystem.NUMERICAL)
    }

    fun customerInfoMenu() {

        requestHandler(readln(), ParseSystem.ALPHANUMERICAL)
    }

    fun leave() {
        println("--------------------------")
        println("-----  Goodbye now!  -----")
        println("--------    :)    --------")
        println("--------------------------")
    }

    private fun genDebugInfo() {
        println("--------------------------")
        println("----- Store # ${store.storeNumber} -------")
        println("----- Store Tote IDs -----")
        println(store.allToteIDs.joinToString())
        println("----- Active Orders ------")
        println(store.getOrdersFromPredicate(false).joinToString("\n"))
        println("------ Past Orders -------")
        println(store.getOrdersFromPredicate(true).joinToString("\n"))
        println("--------------------------")
    }

}