package test

import kotlin.system.exitProcess
import java.util.concurrent.Callable
import picocli.CommandLine.*
import picocli.CommandLine

@Command(
    name= "picoclitest",
    header=["Test Commandline Description"]
)
class TestCommandline(): Callable <Int> {
    @Option(required = true,names = ["-i","-input"], description = ["This represents the input file path"])
    var inputPath: String? = null

    @Option(names = ["-o","--output"], description = ["This represents the output file path"])
    var outputPath: String? = null

    @Option(names = ["-h", "--help"], usageHelp = true, description = ["Utility for Test Commandline Options..."])
    var help = false

    override fun call(): Int {
        when
        {
            help -> exitProcess(0)
            else -> executeCommand(inputPath,outputPath)
        }
        return 0
    }

    private fun executeCommand(inputPath: String?, outputPath: String?) {
        println("Input Path is $inputPath")
        println("Output Path is $outputPath")
    }
}

fun main(args: Array<String>) : Unit =
    exitProcess(CommandLine(TestCommandline()).execute(*args))