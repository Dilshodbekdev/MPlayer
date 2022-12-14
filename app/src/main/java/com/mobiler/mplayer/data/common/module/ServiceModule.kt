package com.mobiler.mplayer.data.common.module

import android.content.Context
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.audio.AudioAttributes
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.util.Util
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ServiceScoped


@Module
@InstallIn(ServiceComponent::class) //restricting ServiceModule lifetime to service lifetime
object ServiceModule {

    /*@ServiceScoped
    @Provides
    fun provideMusicDatabase(@ApplicationContext context: Context) = MusicDatabase(context)*/

    @ServiceScoped //restricting fun lifetime to ServiceModule lifetime
    @Provides
    fun provideAudioAttributes() = AudioAttributes.Builder() //attribute required by our exoplayer
        .setContentType(C.CONTENT_TYPE_MUSIC)
        .setUsage(C.USAGE_MEDIA)
        .build()

    @ServiceScoped
    @Provides
    fun provideExoPlayer(  //creating our exo player instance
        @ApplicationContext context: Context,
        audioAttributes: AudioAttributes
    ) = ExoPlayer.Builder(context).build().apply {
        setAudioAttributes(audioAttributes, true)
        setHandleAudioBecomingNoisy(true)
    }

    @ServiceScoped
    @Provides
    fun provideDataSourceFactory(
        @ApplicationContext context: Context,
    ): DefaultDataSourceFactory {
        // Default parameters, except allowCrossProtocolRedirects is true
        val httpDataSourceFactory = DefaultHttpDataSource.Factory()
        httpDataSourceFactory.setUserAgent(Util.getUserAgent(context, "Audio Book"))
            .setConnectTimeoutMs(DefaultHttpDataSource.DEFAULT_CONNECT_TIMEOUT_MILLIS)
            .setAllowCrossProtocolRedirects(true)
            .createDataSource()
        return DefaultDataSourceFactory(
            context,
            httpDataSourceFactory
        )
    }
}