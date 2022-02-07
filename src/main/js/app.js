import React, { useEffect } from 'react';
import ReactDOM from 'react-dom'; 
import Header from './Components/Header';

import { BrowserRouter, Switch, Route } from 'react-router-dom'
import Form from './views/form';
import { Main } from './views';

const App = () => {
  return (<Main/>)
}

ReactDOM.render(
	<BrowserRouter>
	  <Header />
      <Switch>
          <Route path="/" exact={true} component={Main} />
          <Route path="/admin" component={Form} />
      </Switch>
  </ BrowserRouter>,
	document.getElementById('react')
)