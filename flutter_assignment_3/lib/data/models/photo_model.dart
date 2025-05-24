class PhotoModel {
  final int albumId;
  final String thumbnailUrl;

  PhotoModel({required this.albumId, required this.thumbnailUrl});

  factory PhotoModel.fromJson(Map<String, dynamic> json) {
    return PhotoModel(
      albumId: json['albumId'],
      thumbnailUrl: json['thumbnailUrl'],
    );
  }
}
