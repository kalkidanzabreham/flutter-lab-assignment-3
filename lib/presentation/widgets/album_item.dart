import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class AlbumItem extends StatelessWidget {
  final Map<String, dynamic> album;

  const AlbumItem({super.key, required this.album});

  @override
  Widget build(BuildContext context) {
    return ListTile(
      onTap: () => context.push('/detail', extra: album),
      leading: Container(
        width: 60,
        height: 60,
        decoration: BoxDecoration(
          color: Colors.grey[300],
          borderRadius: BorderRadius.circular(8),
        ),
        clipBehavior: Clip.hardEdge,
        child: Image.network(
          album['thumbnailUrl'] ?? '',
          fit: BoxFit.cover,
          errorBuilder: (context, error, stackTrace) {
            return Image.asset(
              'assets/images/placeholder.png',
              fit: BoxFit.cover,
            );
          },
        ),
      ),
      title: Text(album['title'] ?? 'No Title'),
    );
  }
}
