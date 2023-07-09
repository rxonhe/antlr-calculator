import {Input} from 'antd';
import React from 'react';

const {Search} = Input;

const SearchBar = ({onSearch}) => (
    <Search placeholder="Input your calculation" allowClear onSearch={onSearch}/>
);

export default SearchBar;