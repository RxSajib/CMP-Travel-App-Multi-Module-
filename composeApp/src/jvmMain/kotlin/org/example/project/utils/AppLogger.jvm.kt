package org.example.project.utils

import okhttp3.internal.concurrent.TaskRunner.Companion.logger
import java.util.logging.Level

actual object AppLogger {
    actual fun e(tag: String, message: String, throwable: Throwable?) {
        if (throwable != null) {
            logger.log(Level.SEVERE, "ERROR: [$tag] $message", throwable)
        } else {
            logger.severe("ERROR: [$tag] $message")
        }
    }

    actual fun d(tag: String, message: String) {
        logger.info("DEBUG: [$tag] $message")
    }

    actual fun i(tag: String, message: String) {
        logger.info("INFO: [$tag] $message")
    }
}