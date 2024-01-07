//
//  PostView.swift
//  JSONPlaceholder_iOS
//
//  Created by Omar HossamEldin on 07/01/2024.
//

import SwiftUI

struct PostItemView: View {
    
    var post: PostModel
    var body: some View {
        HStack {
            VStack(alignment: .leading) {
                Text(post.title ?? "")
                    .bold()
                Text(post.body ?? "")
            }
            .padding()
            
            Spacer()
        }
    }
}

#Preview {
    PostItemView(post: post1)
}
