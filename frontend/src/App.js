import React, {Component} from 'react';
import SearchBar from './components/SearchBar';
import ResultFrame from './components/ResultFrame';
import api from './api/axiosConfig.js';
import './css/Util.css';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            result: null,
        };
    }

    handleExpressionEvaluate = (expression) => {
        api.post("/calculator/evaluate", expression, {headers: {'Content-Type': 'application/json'}})
            .then(response => {
                const evaluatedResult = response.data;
                this.setState({result: evaluatedResult});
            })
            .catch(error => {
                console.log(error);
            });
    };


// ...

    render() {
        const {result} = this.state;
        return (
            <div className={"main-page"}>
                <SearchBar onEvaluate={this.handleExpressionEvaluate}/>
                <ResultFrame result={result}/>
            </div>
        );
    }

}

export default App;
