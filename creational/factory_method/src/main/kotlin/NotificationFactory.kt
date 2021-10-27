class NotificationFactory {

    fun createNotification(channel: String?): Notification? {
        if (channel == null || channel.isEmpty())
            return null

        return when (channel) {
            "SMS" -> {
                SMSNotification()
            }
            "EMAIL" -> {
                EmailNotification()
            }
            "PUSH" -> {
                PushNotification()
            }
            else -> null
        }
    }
}
