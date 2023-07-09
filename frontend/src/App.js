import React from 'react';
import {Route, Routes} from "react-router-dom";
import Home from "./components/home/Home";
import Layout from "./components/Layout";

const App = () => {
    return (
        <div className="App">
            <Routes>
                <Route path="/" element={<Layout/>}>
                    <Route path="/" element={<Home/>}/>
                </Route>
            </Routes>
        </div>
    );
};

export default App;