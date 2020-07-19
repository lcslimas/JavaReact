import React from 'react';
import ReactDOM from 'react-dom'; 
import form from './pages/cadastroFilme';
import Header from './Components/Header';
import Home from './pages/home/';

import { BrowserRouter, Switch, Route } from 'react-router-dom'

ReactDOM.render(
	<BrowserRouter>
	<Header />
        <Switch>
            <Route path="/" exact={true} component={Home} />
            <Route path="/admin" component={form} />
        </Switch>
    </ BrowserRouter>,
	document.getElementById('react')
)