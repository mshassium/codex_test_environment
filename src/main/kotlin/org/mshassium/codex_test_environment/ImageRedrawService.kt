package org.mshassium.codex_test_environment

import ai.koog.agents.openai.OpenAIClient
import ai.koog.agents.openai.image.EditImageRequest
import ai.koog.agents.openai.image.EditImageResponse

/**
 * Service that sends an input image to OpenAI with a prompt to redraw it
 * in Ghibli style and returns the resulting image as a base64 string.
 */
class ImageRedrawService(token: String) {

    private val client = OpenAIClient(token)

    /**
     * Redraw the given base64 encoded image using OpenAI with Ghibli style.
     *
     * @param imageBase64 base64 encoded image
     * @return base64 encoded result image
     */
    fun redrawGhibli(imageBase64: String): String {
        val request = EditImageRequest(
            image = imageBase64,
            prompt = "перерисуй в стиле ghibli"
        )
        val response: EditImageResponse = client.createImageEdit(request)
        return response.image
    }
}
