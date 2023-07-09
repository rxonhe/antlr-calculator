import React, {useEffect, useState} from 'react';
import {Col, Row, Typography} from 'antd';
import SearchBar from "../searchBar/SearchBar";
import ResultDisplay from "../resultDisplay/resultDisplay";
import api from "../../api/axiosConfig";

const {Title} = Typography;
const Home = () => {

    const [results, setResults] = useState([]);

    useEffect(() => {
        setResults([]);
    }, []);

    const onSearch = (value) => {
        let result = api.post("/calculator/evaluate", {value})
        result.then((response) => {
            let resultToAppend = `${value} = ${response.data}`
            setResults(results => [resultToAppend, ...results])
            console.log(response.data)
        }).catch((error) => {
                console.log(error)
            }
        )
    }

    return (
        <Col justify={"center"} align={"middle"} style={{height: "70vh"}}>
            <Title style={{color: "#434343"}}>ANTLR Calculator</Title>
            <Col span={12}>
                <Row style={{marginBottom: "10px"}}><SearchBar onSearch={onSearch}/></Row>
                <ResultDisplay results={results}/>
            </Col>
        </Col>
    );
};

export default Home;
