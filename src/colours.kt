class Ansi {
    private val escapeSequence = "\u001b["
    private var compatibilityMode = false
    private var defaultFormatString = ""

    fun setFormat(colourOpt: String) {
        print("${escapeSequence}0m")
        print("${escapeSequence}${colourOpt}m")
        defaultFormatString = if(colourOpt.isNotEmpty()) {
            "$escapeSequence${colourOpt}m"
        } else {
            ""
        }
    }
    fun println(colourOpt: String, string: String) {
        print("${escapeSequence}${colourOpt}m$string")
        print("${escapeSequence}0m")
        print("$defaultFormatString\n")
    }
    fun clear() {
        print("${escapeSequence}2J${escapeSequence}H") //Clear and set cursor home
    }


    fun detectConsole(){
        val console = System.console().toString()
        if (console.contains("Proxying")) {
            ansi.println("1;93","Detected running from proxy terminal (eg IntelliJ) \nContinuing with limited compatibility\n")
            compatibilityMode = true
            Thread.sleep(1000)
            println("\n\n\n\n")
        }
    }

}