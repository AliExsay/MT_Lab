//
//  VideoPicker.swift
//  lab6
//
//  Created by AliExsay on 30.11.2023.
//

//import SwiftUI
//import AVKit
//import PhotosUI
//
//class VideoPicker: ObservableObject {
//    enum VideoImportState {
//        case empty
//        case loading(Progress)
//        case success(AVPlayer)
//        case failure(Error)
//    }
//
//    @Published private(set) var videoImportState: VideoImportState = .empty
//
//    struct VideoType: Transferable {
//        let url: URL
//
//        static private func documentDirectory() -> String {
//            let documentDirectory = NSSearchPathForDirectoriesInDomains(.documentDirectory, .userDomainMask, true)
//
//            return documentDirectory[0]
//        }
//
//        static var transferRepresentation: some TransferRepresentation {
//            FileRepresentation(contentType: .movie) { movie in
//                SentTransferredFile(movie.url)
//
//            } importing: { received in
//
//                let fileName = received.file.lastPathComponent
//
//                let copy: URL = URL(fileURLWithPath: "\(documentDirectory())/\(fileName)")
//                try FileManager.default.copyItem(at: received, to: copy)
//
//                return Self.init(url: copy)
//            }
//
//        }
//
//    }
//
//    @Published var videoSelection: PhotosPickerItem? = nil {
//        didSet {
//            if let videoSelection {
//                let progress = loadTransferableVideo(from: videoSelection)
//                videoImportState = .loading(progress)
//            } else {
//                videoImportState = .empty
//            }
//        }
//    }
//
//    public func loadTransferableVideo(from: PhotosPickerItem) -> Progress {
//        return (videoSelection?.loadTransferable(type: VideoType.self) { result in
//            DispatchQueue.main.async {
//                guard self.videoSelection == self.videoSelection else {
//                    print("Failed to get the selected item")
//                    return
//                }
//                switch result {
//                case .success(let profileVideo?):
//                    let player = AVPlayer(url: profileVideo.url)
//                    self.videoImportState = .success(player)
//                case .success(nil):
//                    self.videoImportState = .empty
//                case .failure(let error):
//                    self.videoImportState = .failure(error)
//                }
//            }
//        })!
//    }
//
//}
