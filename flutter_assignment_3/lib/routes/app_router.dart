import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import '../presentation/screens/album_list_screen.dart';
import '../presentation/screens/album_detail_screen.dart';

final GoRouter appRouter = GoRouter(
  routes: [
    GoRoute(
      path: '/',
      builder: (context, state) => AlbumListScreen(),
    ),
    GoRoute(
      path: '/detail',
      builder: (context, state) => AlbumDetailScreen(album: state.extra as Map<String, dynamic>),
    ),
  ],
);
