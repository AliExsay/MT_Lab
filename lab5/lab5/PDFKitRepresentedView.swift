//
//  PDFKitRepresentedView.swift
//  lab5
//
//  Created by AliExsay on 01.12.2023.
//

import SwiftUI
import PDFKit

struct PDFKitRepresentedView: UIViewRepresentable {
    let documentURL: URL
    
    
    func makeUIView(context: Context) -> some UIView {
        let pdfView = PDFView()
        pdfView.document = PDFDocument(url: documentURL)
        
        pdfView.autoScales = true
        pdfView.maxScaleFactor = 2
        pdfView.minScaleFactor = 0.5
        pdfView.usePageViewController(true)
        
        setThumbnailView(pdfView)
        
        return pdfView
    }
    
    func updateUIView(_ uiView: UIViewType, context: Context) {
        //
    }
    
    private func setThumbnailView(_ pdfView: PDFView) {
        let thumbnailView = PDFThumbnailView()
        
        thumbnailView.translatesAutoresizingMaskIntoConstraints = false
        pdfView.addSubview(thumbnailView)
        thumbnailView.pdfView = pdfView
        
        NSLayoutConstraint.activate([
            thumbnailView.leadingAnchor.constraint(equalTo: pdfView.safeAreaLayoutGuide.leadingAnchor),
            thumbnailView.trailingAnchor.constraint(equalTo: pdfView.safeAreaLayoutGuide.trailingAnchor),
            thumbnailView.bottomAnchor.constraint(equalTo: pdfView.safeAreaLayoutGuide.bottomAnchor),
            thumbnailView.heightAnchor.constraint(equalToConstant: 60)
        ])
        
        thumbnailView.thumbnailSize = CGSize(width: 50, height: 80)
        thumbnailView.layoutMode = .horizontal
        thumbnailView.backgroundColor = .systemGray6
    }
}
