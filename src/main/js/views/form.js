import {Link} from "react-router-dom";
const React = require('react');
const ReactDOM = require('react-dom'); 
import axios from "axios";

export default class Form extends React.Component { 
    constructor(props) {
		super(props);
		this.state = {insert: ''};
	}
    insertMovie(e){
        e.preventDefault();
        let name= document.getElementById("name").value
        let description= document.getElementById("description").value
        let information={
            'name': name,
            'description': description,
            'image': 'http://via.placeholder.com/150'
        }
        axios.post('/api/movies/new', information).then(res=>
            this.setState({insert: res.status})
        );
        document.getElementById("name").value=""
        document.getElementById("description").value=""
    }
    
    render(){
        return(
            <div  className="p-5 border container">
                <h1 className="text-center justify-content-center">Adicionar novos filmes</h1>
                <form onSubmit={(e)=> this.insertMovie(e)} method="post">
                    <div className="form-group col-12" >
                        <label>Nome:</label>
                        <input className="form-control" id="name" type="text" required placeholder="Insira nome do filme"/>
                    </div>
                    <div className="form-group col-12">
                    <label>Descrição:</label>
                    <textarea id="description" className="form-control" required placeholder="Insira descrição do filme"/>
                    </div>
                    <div className="form-group  align-content-end">
                        <button className="btn btn-primary" type="submit">Cadastrar</button>
                    </div>
                </form>
                {this.state.insert==200? 
                
                <div className="alert alert-success" role="alert">
                    Filme cadastrado com sucesso
                </div>:this.state.insert!=200 && this.state.insert!=''?
                <div className="alert alert-danger" role="alert">
                    Falha na adição do filme
                </div>:''
                }
                

                <Link to="/" className="mt-5 btn-link">Voltar para Hub de Filmes</Link>
            </div>
    )}
}