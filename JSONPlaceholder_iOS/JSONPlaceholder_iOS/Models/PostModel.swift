//
//  PostModel.swift
//  JSONPlaceholder_iOS
//
//  Created by Omar HossamEldin on 07/01/2024.
//

import Foundation

struct PostModel : Hashable, Identifiable , Codable {
    var userId: Int?
    var id: Int?
    var title: String?
    var body: String?
}
