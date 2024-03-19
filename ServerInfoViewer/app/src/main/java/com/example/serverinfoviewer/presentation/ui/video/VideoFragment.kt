package com.example.serverinfoviewer.presentation.ui.video

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.example.serverinfoviewer.databinding.FragmentVideoBinding

class VideoFragment : Fragment() {

    private var _binding: FragmentVideoBinding? = null
    val binding: FragmentVideoBinding
            get() = _binding ?: throw RuntimeException("Video fragment binding is null")

    private lateinit var exoPlayer: ExoPlayer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setupPlayer() {
        exoPlayer = ExoPlayer.Builder(requireActivity()).build()
        binding.playerView.player = exoPlayer
        val item = MediaItem.fromUri(VIDEO_LINK)
        exoPlayer.setMediaItem(item)
        exoPlayer.prepare()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPlayer()
    }

    override fun onResume() {
        super.onResume()
        exoPlayer.play()
    }

    override fun onPause() {
        super.onPause()
        exoPlayer.pause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        exoPlayer.stop()
    }

    companion object {
        private const val VIDEO_LINK = "https://www.youtube.com/watch?v=QKWAvLeayec&ab_channel=MARGO"
    }
}