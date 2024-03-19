package com.example.serverinfoviewer.presentation.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.serverinfoviewer.R
import com.example.serverinfoviewer.domain.entities.Address
import com.example.serverinfoviewer.domain.entities.Company
import com.example.serverinfoviewer.domain.entities.User

@Composable
fun ColorInstruction(modifier: Modifier = Modifier) {
    val colorInfo = listOf(
        colorResource(id = R.color.user_info_label_color) to stringResource(id = R.string.user_label),
        colorResource(id = R.color.company_info_label_color) to stringResource(id = R.string.company_label),
        colorResource(id = R.color.address_label_color) to stringResource(id = R.string.address_label)
    )
    Column(modifier) {
        for (i in colorInfo.indices) {
            Text(
                colorInfo[i].second,
                modifier = Modifier
                    .padding(2.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(1f / (colorInfo.size - i))
                    .drawBehind {
                        drawRoundRect(
                            color = colorInfo[i].first,
                            cornerRadius = CornerRadius(150f)
                        )
                    }
                    .padding(5.dp),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun FullUserInfoDesign(user: User = User()) {
    Column(Modifier.fillMaxSize()) {
        ColorInstruction(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .background(Color.White)
        )
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
            ) {
                UserInfoDesign(
                    modifier = Modifier.height(400.dp).fillMaxWidth(),
                    user
                )
                CompanyInfoDesign(
                    modifier = Modifier.height(200.dp).fillMaxWidth(),
                    user.company
                )
                AddressInfoDesign(
                    modifier = Modifier.height(300.dp).fillMaxWidth(),
                    user.address
                )
            }
        }
    }
}

@Composable
fun InfoLabel(
    label: String, data: String,
    modifier: Modifier = Modifier,
    infoLabelColor: Color,
    dataLabelColor: Color,
    labelWidthRatio: Float = 0.3f
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            label,
            modifier = Modifier
                .fillMaxWidth(labelWidthRatio)
                .fillMaxHeight()
                .drawBehind {
                    drawRoundRect(
                        color = infoLabelColor,
                        cornerRadius = CornerRadius(150f)
                    )
                }
                .padding(5.dp),
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Text(
            data,
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight()
                .drawBehind {
                    drawRoundRect(
                        color = dataLabelColor,
                        cornerRadius = CornerRadius(15f)
                    )
                }
                .padding(5.dp),
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun UserInfoDesign(modifier: Modifier = Modifier, user: User = User()) {
    val userInfoBackground = colorResource(id = R.color.white)
    Column(
        modifier = modifier.background(userInfoBackground)
    ) {
        val info = listOf(
            stringResource(id = R.string.id_label) to user.id.toString(),
            stringResource(id = R.string.name_label) to user.name,
            stringResource(id = R.string.user_name_label) to user.userName,
            stringResource(id = R.string.email_label) to user.email,
            stringResource(id = R.string.phone_label) to user.phone,
            stringResource(id = R.string.website_label) to user.website
        )
        for (i in info.indices) {
            InfoLabel(
                info[i].first,
                info[i].second,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f / (info.size - i))
                    .padding(2.dp),
                colorResource(id = R.color.user_info_label_color),
                colorResource(id = R.color.data_label_color)
            )
        }
    }
}

@Composable
fun CompanyInfoDesign(modifier: Modifier = Modifier, company: Company = Company()) {
    val userInfoBackground = colorResource(id = R.color.white)
    Column(
        modifier = modifier.background(userInfoBackground)
    ) {
        val info = listOf(
            stringResource(id = R.string.name_label) to company.name,
            stringResource(id = R.string.catch_phrase_label) to company.catchPhrase,
            stringResource(id = R.string.bs_label) to company.bs
        )
        for (i in info.indices) {
            InfoLabel(
                info[i].first,
                info[i].second,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f / (info.size - i))
                    .padding(2.dp),
                colorResource(id = R.color.company_info_label_color),
                colorResource(id = R.color.data_label_color)
            )
        }
    }
}

@Composable
fun AddressInfoDesign(modifier: Modifier = Modifier, address: Address = Address()) {
    val userInfoBackground = colorResource(id = R.color.white)
    Column(
        modifier = modifier.background(userInfoBackground)
    ) {
        val info = listOf(
            stringResource(id = R.string.name_label) to address.street,
            stringResource(id = R.string.city_label) to address.city,
            stringResource(id = R.string.suite_label) to address.suite,
            stringResource(id = R.string.zipcode_label) to address.zipcode,
            stringResource(id = R.string.geo_label) to "${address.geo.lat}/${address.geo.lng}",
        )
        for (i in info.indices) {
            InfoLabel(
                info[i].first,
                info[i].second,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f / (info.size - i))
                    .padding(2.dp),
                colorResource(id = R.color.address_label_color),
                colorResource(id = R.color.data_label_color)
            )
        }
    }
}
