import React, { useEffect } from 'react';
import ReactDOM from 'react-dom'; 
import Header from './Components/Header';

import { BrowserRouter, Switch, Route } from 'react-router-dom'
import { MovieEdit } from './views/movie/edit';
import { Main } from './views/movie/list/index';

const App = () => {
  return (<Main/>)
}

ReactDOM.render(
	<BrowserRouter>
	  <Header />
      <Switch>
          <Route path="/movies" exact component={Main} />
          <Route path="/movies/:id" component={MovieEdit} />
          <Route path="/movies/new" component={MovieEdit} />
      </Switch>
  </ BrowserRouter>,
	document.getElementById('react')
)