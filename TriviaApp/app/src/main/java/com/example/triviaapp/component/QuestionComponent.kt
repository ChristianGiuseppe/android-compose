package com.example.triviaapp.component

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviaapp.model.QuestionItem
import com.example.triviaapp.screen.QuestionViewModel
import com.example.triviaapp.util.APPColor


@Composable
fun Question(viewModel: QuestionViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()

    val questionIndex = remember {
        mutableStateOf(0)
    }

    if (viewModel.data.value.loading == true) {
        Surface(
            modifier = Modifier
                .height(32.dp)
                .width(32.dp)
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp)
            )
        }

        Log.d("Loading list ", "Questions: .....Loading......")
    } else {


        if (questions != null) {
            val question = try {
                questions[questionIndex.value]
            } catch (ex: Exception) {
                null
            }
            QuestionDisplay(
                questionItem = question!!,
                questionIndex = questionIndex,
                viewModel = viewModel
            ) {
                questionIndex.value = questionIndex.value + 1
            }
        }

    }

}


@Composable
fun QuestionDisplay(
    questionItem: QuestionItem,
    questionIndex: MutableState<Int>,
    viewModel: QuestionViewModel,
    onNextClicked: (Int) -> Unit = {}
) {


    val choiceState = remember(questionItem) {
        questionItem.choices.toMutableList()
    }

    val answerState = remember(questionItem) {
        mutableStateOf<Int?>(null)
    }

    val correctQuestion = remember(questionItem) {
        mutableStateOf<Boolean?>(null)
    }

    val updateAnswer: (Int) -> Unit = remember(questionItem) {
        {
            answerState.value = it
            correctQuestion.value = choiceState[it] == questionItem.answer
        }
    }

    val totalQuestion = viewModel.data.value.data?.size ?: 0

    val pathEffect =
        androidx.compose.ui.graphics.PathEffect.dashPathEffect(floatArrayOf(20f, 20f), 0f)
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = APPColor.mDarkPurple
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            ShowProgress(score = questionIndex.value)
            QuestionTracker(counter = questionIndex.value, outOf = totalQuestion)
            DottedLine(pathEffect = pathEffect)
            Column(modifier = Modifier.padding(top = 8.dp)) {
                Text(
                    text = questionItem.question,
                    color = APPColor.mOffWhite,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 22.sp,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .fillMaxHeight(0.3f),

                    )

                choiceState.forEachIndexed { index, answerText ->
                    Row(
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth()
                            .height(45.dp)
                            .border(
                                width = 4.dp,
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        APPColor.mOffDarkPurple,
                                        APPColor.mOffDarkPurple
                                    )
                                ),
                                shape = RoundedCornerShape(15.dp)
                            )
                            .clip(
                                RoundedCornerShape(
                                    topEndPercent = 50,
                                    bottomEndPercent = 50,
                                    topStartPercent = 50,
                                    bottomStartPercent = 50
                                )
                            )
                            .background(
                                Color.Transparent
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = answerState.value == index,
                            onClick = {
                                updateAnswer(index)
                            },
                            modifier = Modifier.padding(start = 16.dp),
                            colors = RadioButtonDefaults.colors(
                                selectedColor = if (correctQuestion.value == true
                                    && index == answerState.value
                                ) {
                                    Color.Green.copy(alpha = 0.2f)
                                } else {
                                    Color.Red.copy(alpha = 0.2f)
                                }
                            )
                        )

                        Text(text = answerText, color = APPColor.mOffWhite)
                    }
                }

                Button(
                    onClick = {
                        onNextClicked(questionIndex.value)
                    }, modifier = Modifier
                        .padding(3.dp)
                        .align(Alignment.CenterHorizontally),
                    shape = RoundedCornerShape(34.dp),
                    colors = buttonColors(
                        backgroundColor = APPColor.mLightBlue
                    )
                ) {
                    Text(
                        text = "Next",
                        modifier = Modifier.padding(4.dp),
                        color = APPColor.mOffWhite,
                        fontSize = 17.sp
                    )
                }

            }
        }
    }

}

@Composable
fun QuestionTracker(counter: Int = 10, outOf: Int = 100) {
    Text(text = buildAnnotatedString {
        withStyle(style = ParagraphStyle(textIndent = TextIndent.None)) {
            withStyle(
                style = SpanStyle(
                    color = APPColor.mLightGray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 27.sp
                )
            ) {
                append("Question $counter/")
                withStyle(
                    style = SpanStyle(
                        color = APPColor.mLightGray,
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp
                    )
                ) {
                    append("$outOf")
                }
            }
        }
    }, modifier = Modifier.padding(20.dp))

}


@Composable
fun DottedLine(pathEffect: androidx.compose.ui.graphics.PathEffect) {
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(1.dp), onDraw = {
        drawLine(
            color = APPColor.mLightGray,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = pathEffect
        )
    })
}


@Preview
@Composable
fun ShowProgress(score: Int = 12) {
    val progressFactorScore by remember(score) {
        mutableStateOf(score * 0.005f)
    }
    val  gradient = Brush.linearGradient(listOf(Color(0xFFF95975), Color(0xFFBE6BE5)))
    Row(

        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .height(45.dp)
            .border(
                width = 4.dp,
                brush = Brush.linearGradient(
                    colors = listOf(
                        APPColor.mLightPurple,
                        APPColor.mLightPurple
                    )
                ),
                shape = RoundedCornerShape(34.dp)
            )
            .clip(
                RoundedCornerShape(
                    topStartPercent = 50,
                    topEndPercent = 50,
                    bottomStartPercent = 50,
                    bottomEndPercent = 50
                )
            )
            .background(Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth(progressFactorScore)
                .background(brush = gradient),
            elevation = null,
            colors = buttonColors(
                backgroundColor = Color.Transparent,
                disabledBackgroundColor = Color.Transparent
            ),
            contentPadding = PaddingValues(1.dp),
            onClick = { /*TODO*/ }
        ) {


        }

        Text(text = (score * 10).toString(),
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight(0.5f)
                .align(alignment = Alignment.CenterVertically),
            color = APPColor.mOffWhite,
            textAlign = TextAlign.Center,
        )
    }
}