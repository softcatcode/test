package com.example.serverinfoviewer.presentation.ui.video

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.example.serverinfoviewer.databinding.FragmentVideoBinding


class VideoFragment : Fragment() {

    private var _binding: FragmentVideoBinding? = null
    val binding: FragmentVideoBinding
            get() = _binding ?: throw RuntimeException("Video fragment binding is null")

    private lateinit var player: ExoPlayer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setupPlayer() {
        player = ExoPlayer.Builder(requireActivity().baseContext).build()
        binding.playerView.player = player
        //val item = MediaItem.fromUri("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
        val item = MediaItem.fromUri(VIDEO_LINK)
        player.setMediaItem(item)
        player.prepare()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPlayer()
    }

    override fun onResume() {
        super.onResume()
        player.play()
    }

    override fun onPause() {
        super.onPause()
        player.pause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        player.stop()
        _binding = null
    }

    companion object {
        private const val VIDEO_LINK = "https://youtu.be/QKWAvLeayec"
    }
}