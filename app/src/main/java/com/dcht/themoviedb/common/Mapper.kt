package com.dcht.themoviedb.common

interface Mapper<Input, Output> {
    fun map(input: Input): Output
}
