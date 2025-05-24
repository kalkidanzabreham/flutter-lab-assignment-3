import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'data/repositories/album_repository.dart';
import 'presentation/blocs/album/album_bloc.dart';
import 'presentation/blocs/album/album_event.dart';
import 'routes/app_router.dart';

void main() {
  final albumRepository = AlbumRepository();
  runApp(MyApp(repository: albumRepository));
}

class MyApp extends StatelessWidget {
  final AlbumRepository repository;

  MyApp({required this.repository});

  @override
  Widget build(BuildContext context) {
    return BlocProvider(
      create: (_) => AlbumBloc(repository)..add(LoadAlbums()),
      child: MaterialApp.router(
        title: 'Flutter Albums',
        debugShowCheckedModeBanner: false,
        routerConfig: appRouter,
      ),
    );
  }
}
