import 'dart:convert';
import 'package:http/http.dart' as http;
import '../models/album_model.dart';
import '../models/photo_model.dart';

class AlbumRepository {
  Future<List<Map<String, dynamic>>> fetchAlbumsWithPhotos() async {
    final albumRes = await http.get(Uri.parse('https://jsonplaceholder.typicode.com/albums'));
    final photoRes = await http.get(Uri.parse('https://jsonplaceholder.typicode.com/photos'));

    if (albumRes.statusCode == 200 && photoRes.statusCode == 200) {
      final albums = (json.decode(albumRes.body) as List).map((e) => AlbumModel.fromJson(e)).toList();
      final photos = (json.decode(photoRes.body) as List).map((e) => PhotoModel.fromJson(e)).toList();

      return albums.map((album) {
        final photo = photos.firstWhere((p) => p.albumId == album.id, orElse: () => PhotoModel(albumId: album.id, thumbnailUrl: ''));
        return {
          'id': album.id,
          'title': album.title,
          'thumbnailUrl': photo.thumbnailUrl,
        };
      }).toList();
    } else {
      throw Exception('Failed to fetch data');
    }
  }
}
