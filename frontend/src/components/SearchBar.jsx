import React, { Component } from 'react';
import '../css/SearchBar.css';

class SearchBar extends Component {
    constructor(props) {
        super(props);
        this.state = {
            expression: '',
        };
    }

    handleExpressionChange = (e) => {
        this.setState({ expression: e.target.value });
    };

    handleEvaluateClick = () => {
        const { expression } = this.state;
        const { onEvaluate } = this.props;
        onEvaluate(expression);
    };

    render() {
        const { expression } = this.state;
        return (
            <div className={"search-bar-container"}>
                <input type="text" value={expression} className={"input"} onChange={this.handleExpressionChange} />
                <button onClick={this.handleEvaluateClick} className={"button"}>Evaluate</button>
            </div>
        );
    }
}

export default SearchBar;
