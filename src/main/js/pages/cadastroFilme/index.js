const React = require('react');
import axios from "axios";

export default class Form extends React.Component { 
    insertMovie(e){
        e.preventDefault();
        console.log(e);
        axios.post('/api/insert', { 'name': 'Marlon', 'description': 'desc' })
    }
    
    render(){
        return(
        <form onSubmit={(e)=> this.insertMovie(e)} method="post" >
            <div className="col-6">Name:</div><div className="col-6"><input type="text" /></div>
            <div className="col-6">Description:</div><div className="col-6"><input type="text" /></div>
            <button className="btn btn-danger" type="submit">Cadastrar</button>
        </form>
    )}
}