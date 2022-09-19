package com.mobiler.mplayer.utils

import kotlinx.coroutines.channels.Channel

object Controller {

    val fetchNewSource = Channel<Boolean>(capacity = 1)

}