class InputHandler(private val store: Store) {

    private var doLoop = true

    private fun greet() {
        println("""
                --------------------------
                --- Welcome to GIF 9.0 ---
                -- Developed by Gabriel --
                --------------------------
                """.trimIndent())
    }

    private fun leave() {
        println("""
                --------------------------
                -----  Goodbye now!  -----
                --------    :)    --------
                --------------------------
                """.trimIndent())
        doLoop = false
    }

    private fun mainMenu() {
        println("""
            
                Select an option:
                --------------------------
                1. View all Tote IDs
                2. View all Active OSNs
                3. View all Past OSNs
                4. Get customer info
                5. Generate OSN
                6. Generate Tote ID
                7. Lookup Order using OSN
                8. Greet
                9. Exit
                100. genDebugInfo
                --------------------------
                """.trimIndent())
        when(getInt(readln())) {
            1 -> println("\n" + store.allToteIDs.joinToString())
            2 -> println("\n" + store.getOSNsFromPredicate(false).joinToString())
            3 -> println("\n" + store.getOSNsFromPredicate(true).joinToString())
            4 -> {
                println("\nOnly show active customers? true / false")
                println("\n" + store.getCustomerList(!getBool(readln())).joinToString("").trimIndent())
            }
            5 -> println("\n" + store.assignOSN())
            6 -> {
                println("\n" + store.assignToteID())
                store.allToteIDs.remove(store.allToteIDs.lastIndex)
            }
            7 -> println("\n" + store.getOrderFromOSN(getInt(readln())).toString())
            8 -> greet()
            9 -> leave()
            100 -> genDebugInfo()
            else -> {
                println("\nInvalid number specified")
            }
        }
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
        println("----- Generated OSN: -----")
        println(store.assignOSN())
        println("--- Generated Tote ID: ---")
        println(store.assignToteID())
        store.allToteIDs.remove(store.allToteIDs.lastIndex)
        println("--------------------------")
    }

    private fun getInt(input: String): Int {
        return input.toIntOrNull() ?: 0
    }

    private fun getBool(input: String): Boolean {
        return input.toBooleanStrictOrNull() ?: false
    }

    fun runLoop() {
        greet()
        while(doLoop) {
            mainMenu()
        }
    }

}