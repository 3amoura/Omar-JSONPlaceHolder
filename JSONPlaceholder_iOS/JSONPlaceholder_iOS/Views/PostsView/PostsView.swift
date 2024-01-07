//
//  ContentView.swift
//  JSONPlaceholder_iOS
//
//  Created by Omar HossamEldin on 07/01/2024.
//

import SwiftUI

struct PostsView: View {
    @EnvironmentObject var viewModel: PostsViewModel
    @State var isPostOpened = false
    @State var selecdtedPost = post1
    var body: some View {
        NavigationView {
            VStack {
                Text("Posts").bold()
                ScrollView {
                    LazyVStack {
                        ForEach(viewModel.posts, id: \.self) { post in
                            
                            Button {
                                selecdtedPost = post
                                isPostOpened = true
                            } label: {
                                PostItemView(post: post)
                            }
                            .buttonStyle(.plain)
                        }
                        .background(
                             NavigationLink(destination: PostView(post: selecdtedPost, isPostOpened: $isPostOpened)
                                .navigationBarHidden(true)
                                .navigationBarTitle(""),
                                            isActive: $isPostOpened) {EmptyView()}
                         )
                    }
                }
            }
            .onAppear(perform: {
                viewModel.loadPosts()
            })
        }
    }
}

#Preview {
    PostsView().environmentObject(PostsViewModel())
}
