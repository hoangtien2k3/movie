package com.hoangtien2k3.movie.common

interface Mapper<Input, Output> {
    fun map(input: Input): Output
}
