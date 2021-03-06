package com.arequa.eventssdk

/**
 * Created by FCD on 28/05/2018.
 */
object Routes {

    const val CHEAP_SHARK_STEAMS_STORE = "1"

    const val BASE_URL = "https://steamspy.com/api.php/"
    const val BASE_URL_STEAM_SPY = "https://steamspy.com/api.php"
    const val BASE_URL_CHEAP_SHARK = "https://cheapshark.com/api/1.0"

    const val GET_TOP_100_GAMES = BASE_URL_STEAM_SPY + "?request=top100gamesin2weeks"
    const val GET_MOST_OWNED_GAMES = BASE_URL_STEAM_SPY + "?request=top100owned"
    const val GET_DEALS = BASE_URL_CHEAP_SHARK + "?deals?storeID=" + CHEAP_SHARK_STEAMS_STORE

    const val URL_CHARACTERS = "http://5b16590aa1c7e300147c871a.mockapi.io/characters"

}