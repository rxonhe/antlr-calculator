import React, {Component} from 'react';
import SearchBar from './SearchBar';
import ResultFrame from './ResultFrame';
import axios from 'axios';
import API_CONFIG from "../config/config";
import '../css/Util.css';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            result: null,
        };
    }

    handleExpressionEvaluate = (expression) => {
        const { baseURL, endpoints } = API_CONFIG;
        const evaluateURL = baseURL + endpoints.evaluate;
         // Use the expression value directly
        axios
            .post(evaluateURL, expression, { headers: { 'Content-Type': 'application/json' } })
            .then(response => {
                const evaluatedResult = response.data;
                this.setState({ result: evaluatedResult });
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
