package org.mshassium.codex_test_environment

/**
 * Example entry point demonstrating the image redrawing service.
 * Set environment variable `OPENAI_TOKEN` with your OpenAI API token
 * and provide a base64 encoded image string as the first command line argument.
 */
fun main(args: Array<String>) {
    val token = System.getenv("OPENAI_TOKEN")
        ?: error("OPENAI_TOKEN environment variable is not set")

    if (args.isEmpty()) {
        println("Please provide a base64 encoded image as the first argument")
        return
    }

    val inputImage = args[0]
    val service = ImageRedrawService(token)
    val result = service.redrawGhibli(inputImage)
    println(result)
}
