import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class AlbumDetailScreen extends StatelessWidget {
  final Map<String, dynamic> album;

  const AlbumDetailScreen({super.key, required this.album});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Album Details'),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () => context.pop(),
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            Image.network(album['thumbnailUrl']),
            const SizedBox(height: 16),
            Text('ID: ${album['id']}'),
            const SizedBox(height: 8),
            Text('Title: ${album['title']}'),
          ],
        ),
      ),
    );
  }
}
