//
//  VideoView.swift
//  lab6
//
//  Created by AliExsay on 01.12.2023.
//

import SwiftUI
import AVKit

struct VideoView: View {
    
    
    
    var body: some View {
        VStack {
            player().frame(height: UIScreen.main.bounds.height / 2.3)
            Spacer()
        }
    }
}

struct VideoView_Previews: PreviewProvider {
    static var previews: some View {
        VideoView()
        
    }
}й

struct player: UIViewControllerRepresentable {
    
    func makeUIViewController(context: UIViewControllerRepresentableContext<player>) -> AVPlayerViewController {
        
        let controller = AVPlayerViewController()
        let url = "https://vod-progressive.akamaized.net/exp=1701435971~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F256%2F7%2F176282263%2F572345165.mp4~hmac=baa433dabfa491133807619ed192c7f7084a749eeb0ae12441e49878d03be1c5/vimeo-prod-skyfire-std-us/01/256/7/176282263/572345165.mp4?filename=file.mp4"
        let player1 = AVPlayer(url: URL(string: url)!)
//        let player2 = AVPlayer(
        controller.player = player1
        return controller
    }
    
    func updateUIViewController(_ uiViewController: AVPlayerViewController, context: UIViewControllerRepresentableContext<player>) {
        
    }
}
