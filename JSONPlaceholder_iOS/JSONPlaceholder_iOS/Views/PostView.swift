//
//  PostView.swift
//  JSONPlaceholder_iOS
//
//  Created by Omar HossamEldin on 07/01/2024.
//

import SwiftUI

struct PostView: View {
    var post: PostModel
    @Binding var isPostOpened: Bool
    var body: some View {
        VStack {
            ZStack {
                HStack {
                    Text(post.title ?? "").bold()
                }
                .padding(.horizontal, 30)
                
                HStack {
                    Button {
                        isPostOpened = false
                    } label: {
                        Image(systemName: "arrow.backward")
                    }

                    Spacer()
                }
            }
            .padding(.bottom, 8)
            
            HStack(alignment: .top) {
                Text("User Id:").bold()
                Text(String(post.userId ?? 0))
                Spacer()
            }
            .padding(.bottom, 8)
            
            HStack(alignment: .top) {
                Text("Id:").bold()
                Text(String(post.id ?? 0))
                Spacer()
            }
            .padding(.bottom, 8)
            
            HStack(alignment: .top) {
                Text("Body:").bold()
                Text(post.body ?? "")
                Spacer()
            }
            .padding(.bottom, 8)
            
            Spacer()
        }
        .padding()
    }
}

#Preview {
    PostView(post: post1, isPostOpened: .constant(true))
}
