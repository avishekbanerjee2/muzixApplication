import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

 
import { ContainerComponent } from './components/container/container.component';
import { TmdbContainerComponent } from './components/tmdb-container/tmdb-container.component';
import { BookmarkComponent } from './components/bookmark/bookmark.component';
import { MuzixSearchComponent } from './components/muzix-search/muzix-search.component';
import { AuthguardService } from './../../authguard.service';
import { PlaylistComponent } from './components/playlist/playlist.component';

const muzixRoutes: Routes = [{
    path: 'muzix',
    children: [
        {
            path: '',
            redirectTo: '/muzix/suggest',
            pathMatch: 'full',
            canActivate: [AuthguardService]
        },
        {
            path: 'suggest',
            component: TmdbContainerComponent,
            canActivate: [AuthguardService],
            data: {
                movieType: 'popular'
            }
        },
        {
            path: 'playlist',
            component: PlaylistComponent,
            canActivate: [AuthguardService],
            data: {
                movieType: 'top_rated'
            }
        },
        {
            path: 'bookmark',
            canActivate: [AuthguardService],
            component: BookmarkComponent
        },
        {
            path: 'search',
            canActivate: [AuthguardService],
            component: MuzixSearchComponent
        }
    ]
}]

@NgModule({
imports: [
    RouterModule.forChild(muzixRoutes)
],
declarations: [],
exports: [RouterModule],
providers: []
})

export class MuzixRouterModule {}